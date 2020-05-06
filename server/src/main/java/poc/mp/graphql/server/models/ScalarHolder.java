/*
 * Copyright (c) 2020 Contributors to the Eclipse Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package poc.mp.graphql.server.models;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Plain POJO with scalar fields
 * @author Phillip Kruger (phillip.kruger@redhat.com)
 */
public class ScalarHolder {
    // Boolean
    private boolean booleanPrimitive;
    private Boolean booleanObject;

    // Byte
    private byte bytePrimitive;
    private Byte byteObject;

    // Short
    private short shortPrimitive;
    private Short shortObject;

    // Integer
    private int intPrimitive;
    private Integer intObject;
    
    // Long
    private long longPrimitive;
    private Long longObject;

    // Float
    private float floatPrimitive;
    private Float floatObject;
    
    // Double
    private double doublePrimitive;
    private Double doubleObject;
    
    // BigInteger
    private BigInteger bigIntegerObject;
    
    // BigDecimal
    private BigDecimal bigDecimalObject;

    // Character
    private char charPrimitive;
    private Character charObject;

    // String
    private String stringObject;

    public ScalarHolder() {

    }

    public boolean isBooleanPrimitive() {
        return booleanPrimitive;
    }

    public void setBooleanPrimitive(boolean booleanPrimitive) {
        this.booleanPrimitive = booleanPrimitive;
    }

    public Boolean getBooleanObject() {
        return booleanObject;
    }

    public void setBooleanObject(Boolean booleanObject) {
        this.booleanObject = booleanObject;
    }

    public byte getBytePrimitive() {
        return bytePrimitive;
    }

    public void setBytePrimitive(byte bytePrimitive) {
        this.bytePrimitive = bytePrimitive;
    }

    public Byte getByteObject() {
        return byteObject;
    }

    public void setByteObject(Byte byteObject) {
        this.byteObject = byteObject;
    }

    public short getShortPrimitive() {
        return shortPrimitive;
    }

    public void setShortPrimitive(short shortPrimitive) {
        this.shortPrimitive = shortPrimitive;
    }

    public Short getShortObject() {
        return shortObject;
    }

    public void setShortObject(Short shortObject) {
        this.shortObject = shortObject;
    }

    public int getIntPrimitive() {
        return intPrimitive;
    }

    public void setIntPrimitive(int intPrimitive) {
        this.intPrimitive = intPrimitive;
    }

    public Integer getIntObject() {
        return intObject;
    }

    public void setIntObject(Integer intObject) {
        this.intObject = intObject;
    }

    public long getLongPrimitive() {
        return longPrimitive;
    }

    public void setLongPrimitive(long longPrimitive) {
        this.longPrimitive = longPrimitive;
    }

    public Long getLongObject() {
        return longObject;
    }

    public void setLongObject(Long longObject) {
        this.longObject = longObject;
    }

    public float getFloatPrimitive() {
        return floatPrimitive;
    }

    public void setFloatPrimitive(float floatPrimitive) {
        this.floatPrimitive = floatPrimitive;
    }

    public Float getFloatObject() {
        return floatObject;
    }

    public void setFloatObject(Float floatObject) {
        this.floatObject = floatObject;
    }

    public double getDoublePrimitive() {
        return doublePrimitive;
    }

    public void setDoublePrimitive(double doublePrimitive) {
        this.doublePrimitive = doublePrimitive;
    }

    public Double getDoubleObject() {
        return doubleObject;
    }

    public void setDoubleObject(Double doubleObject) {
        this.doubleObject = doubleObject;
    }

    public BigInteger getBigIntegerObject() {
        return bigIntegerObject;
    }

    public void setBigIntegerObject(BigInteger bigIntegerObject) {
        this.bigIntegerObject = bigIntegerObject;
    }

    public BigDecimal getBigDecimalObject() {
        return bigDecimalObject;
    }

    public void setBigDecimalObject(BigDecimal bigDecimalObject) {
        this.bigDecimalObject = bigDecimalObject;
    }

    public char getCharPrimitive() {
        return charPrimitive;
    }

    public void setCharPrimitive(char charPrimitive) {
        this.charPrimitive = charPrimitive;
    }

    public Character getCharObject() {
        return charObject;
    }

    public void setCharObject(Character charObject) {
        this.charObject = charObject;
    }

    public String getStringObject() {
        return stringObject;
    }

    public void setStringObject(String stringObject) {
        this.stringObject = stringObject;
    }
}