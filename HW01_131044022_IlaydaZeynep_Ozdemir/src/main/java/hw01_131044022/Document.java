/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw01_131044022;

/**
 *
 * @author ilayda
 */
public abstract class Document {

    private String nameOfDocument;

    /**
     * no parameter contructor
     */
    public Document() {
        setNameOfDocument("isimsizDocument");
    }

    /**
     * contructor
     *
     * @param nameDocument verilen document ismi
     */
    public Document(String nameDocument) {
        setNameOfDocument(nameDocument);
    }

    /**
     * documentin adini set eder
     *
     * @param name documentin adi
     */
    public void setNameOfDocument(String name) {
        this.nameOfDocument = name;
    }

    /**
     * documentin adini get eder
     *
     * @return string
     */
    public String getNameOfDocument() {
        return nameOfDocument;
    }

    @Override
    public boolean equals(Object other) {

        if (other == null) {
            return false;
        }
        if (other == this) {
            return true;
        }
        if (!(other instanceof Document)) {
            return false;
        }
        Document temp = (Document) other;
        return (temp.getNameOfDocument() == getNameOfDocument());
    }

}
