package com.fundacio.esplai.hacktahon.model.exceptions;

import java.util.List;

public record ErrorResponse(String message, List<ValidationError> errors) {
}
