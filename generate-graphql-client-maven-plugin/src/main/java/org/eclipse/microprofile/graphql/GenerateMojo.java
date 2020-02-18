package org.eclipse.microprofile.graphql;

import org.apache.maven.model.Dependency;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import java.util.List;

@Mojo(name = "generate-graphql-client", defaultPhase = LifecyclePhase.COMPILE)
public class GenerateGraphQLClientMojo extends AbstractMojo {
    @Parameter(defaultValue = "${project}", required = true, readonly = true)
    MavenProject project;

    /**
     * The Json file with the result of the introspection query against the server.
     * Use https://github.com/prisma-labs/get-graphql-schema ?
     */
    @Parameter(property = "introspectionQueryResultJsonFilePath")
    String pathToSchema;
    /**
     * The Java package of the generated classes
     */
    @Parameter(property = "outputPackageName")
    String outputPackageName;
    /**
     * The license header that will be added to all Java files
     * ERB ruby file.
     */
    @Parameter(property = "licenceHeaderFilePath")
    String licenceHeaderFilePath;

    private void generateDTOClasses() {
        // How to call ruby ??
        getLog().info("pathToSchema: " + pathToSchema);
        getLog().info("outputPackageName: " + outputPackageName);
        getLog().info("licenceHeaderFilePath: " + licenceHeaderFilePath);
    }

    public void execute() throws MojoExecutionException, MojoFailureException {
        getLog().info("### generate-graphql-client :: START ###");
        this.generateDTOClasses();
        getLog().info("### generate-graphql-client :: END ###");
    }
}