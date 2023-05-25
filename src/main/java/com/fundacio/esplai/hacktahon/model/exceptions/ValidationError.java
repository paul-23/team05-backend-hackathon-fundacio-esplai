package com.fundacio.esplai.hacktahon.model.exceptions;

public record ValidationError(String field, String message) {
}
