package org.phonenums.phoneproj.phoneEditor;

import org.phonenums.phoneproj.phonenumber.PhoneNumber;

public class PhoneEditor extends java.beans.PropertyEditorSupport {

    @Override
    public void setAsText(String textValue) throws IllegalArgumentException {
        final String stripped = strippedNonNumeric(textValue);

        final String areaCode = stripped.substring(0, 3);
        final String prefix = stripped.substring(3, 6);
        final String number = stripped.substring(6);

        final PhoneNumber phone = new PhoneNumber(areaCode, prefix, number);
        setValue(phone);
    }

    private String strippedNonNumeric(String value) {
        StringBuffer allNumeric = new StringBuffer();
        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            if (Character.isDigit(c)) {
                allNumeric.append(c);
            }
        }
        return allNumeric.toString();
    }

}
