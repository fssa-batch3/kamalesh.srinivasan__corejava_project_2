package com.fssa.needstobedone.validation;

import java.util.regex.Pattern;
import com.fssa.needstobedone.exception.ValidationException;
import com.fssa.needstobedone.model.Job;

public class JobValidator {

    public void validateJob(Job job) throws ValidationException {
        if (job != null) {
            validateTitle(job.getTitle());
            validateLocation(job.getLocation());
            validatePrice(job.getPrice());
            validateDescription(job.getDescription());
            validateSummary(job.getSummary());
            validateQualification(job.getQualification());
            validateResponsibilities(job.getResponsibilities());
            validateUserId(Integer.toString(job.getUserId()));
        }
    }

    public boolean validateTitle(String title) throws ValidationException {
        if (title == null || title.isEmpty()) {
            throw new ValidationException("Job title is not valid - title cannot be empty");
        }
        if (!Pattern.matches("^[A-Za-z ]{1,30}$", title)) {
            throw new ValidationException("Job title is not valid - should contain alphabets and be up to 30 characters long");
        }
        return true;
    }

    public boolean validateLocation(String location) throws ValidationException {
        if (location == null || location.isEmpty()) {
            throw new ValidationException("Job location is not valid - location cannot be empty");
        }
        if (!Pattern.matches("^[A-Za-z]{1,30}$", location)) {
            throw new ValidationException("Job location is not valid - should contain alphabets and be up to 30 characters long");
        }
        return true;
    }

    public boolean validateDescription(String description) throws ValidationException {
        if (description == null || description.isEmpty()) {
            throw new ValidationException("Job description is not valid - description cannot be empty");
        }
        if (description.length() > 200) {
            throw new ValidationException("Job description is not valid - should be up to 200 characters long");
        }
        return true;
    }

    public boolean validateSummary(String summary) throws ValidationException {
        // Default validation: Summary can't be empty, but no specific format constraints provided
        if (summary == null || summary.isEmpty()) {
            throw new ValidationException("Job summary is not valid - summary cannot be empty");
        }
        return true;
    }

    public boolean validateQualification(String qualification) throws ValidationException {
        // Default validation: Qualification can't be empty, but no specific format constraints provided
        if (qualification == null || qualification.isEmpty()) {
            throw new ValidationException("Job qualification is not valid - qualification cannot be empty");
        }
        return true;
    }

    public boolean validateResponsibilities(String responsibilities) throws ValidationException {
        // Default validation: Responsibilities can't be empty, but no specific format constraints provided
        if (responsibilities == null || responsibilities.isEmpty()) {
            throw new ValidationException("Job responsibilities are not valid - responsibilities cannot be empty");
        }
        return true;
    }

    public boolean validatePrice(int price) throws ValidationException {
        if (price <= 0) {
            throw new ValidationException("Job Price is not valid - Price should be a positive number");
        }
        return true;
    }

    public boolean validateUserId(String userId) throws ValidationException {
        if (userId == null || userId.isEmpty()) {
            throw new ValidationException("User ID is not valid - User ID cannot be empty");
        }
        return true;
    }
}
