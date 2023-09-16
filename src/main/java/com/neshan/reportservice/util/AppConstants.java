package com.neshan.reportservice.util;

public class AppConstants {
    public static final String DEFAULT_PAGE_NUMBER = "0";
    public  static final String DEFAULT_PAGE_SIZE = "10";
    public static final String DEFAULT_SORT_BY = "id";

    public static final String[] POST_UN_SECURED_URLs = {
            "/register",
            "/login",
            "/routing",
            "/reports/{reportId}/feedback"
    };

    public static final String[] GET_USER_SECURED_URLs = {
            "/me"
    };

    public static final String[] PATCH_USER_SECURED_URLs = {
            "/update-me"
    };

    public static final String[] DELETE_USER_SECURED_URLs = {
            "/delete-me"
    };

    public static final String[] GET_OPERATOR_SECURED_URLs = {
            "/approval-reports/**"
    };

    public static final String[] PATCH_OPERATOR_SECURED_URLs = {
            "/approval-reports/{reportId}"
    };

    public static final String[] GET_ADMIN_SECURED_URLs = {
            "/users/**",
            "/reports/**"
    };

    public static final String[] PATCH_ADMIN_SECURED_URLs = {
            "/reports/**"
    };

    public static final String[] DELETE_ADMIN_SECURED_URLs = {
            "/users/**",
            "/reports/**"
    };

    public static final String[] POST_USER_ADMIN_SECURED_URLs = {
            "/reports"
    };
}
