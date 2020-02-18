require 'graphql_java_gen_adobe'
require 'graphql_schema'
require 'json'

def generate(pathToSchema, licenseHeaderFilePath, outputPackageName, outputDirPath)
    puts "### WORKDIR: #{Dir.pwd}"

    ## Convert Windows paths to Unix paths
    pathToSchema = pathToSchema.gsub!(File::ALT_SEPARATOR, File::SEPARATOR) if File::ALT_SEPARATOR
    licenseHeaderFilePath = licenseHeaderFilePath.gsub!(File::ALT_SEPARATOR, File::SEPARATOR) if File::ALT_SEPARATOR
    outputDirPath = outputDirPath.gsub!(File::ALT_SEPARATOR, File::SEPARATOR) if File::ALT_SEPARATOR
    #

    ## Parse the graphql schema
    introspection_result = File.read(pathToSchema)
    schema = GraphQLSchema.new(JSON.parse(introspection_result))
    #

    GraphQLJavaGenAdobe.new(schema,
      package_name: outputPackageName,
      license_header_file: licenseHeaderFilePath,
      nest_under: 'Schema', # Not used, but must be defined
      custom_scalars: [
        GraphQLJavaGenAdobe::Scalar.new(
          type_name: 'Decimal',
          java_type: 'BigDecimal',
          deserialize_expr: ->(expr) { "new BigDecimal(jsonAsString(#{expr}, key))" },
          imports: ['java.math.BigDecimal'],
        ),
      ]
    ).save_granular("#{Dir.pwd}/target")
end