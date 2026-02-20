package com.cineprime.api.user.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @GetMapping("/health")
    public String getUserDetails(){
        return "User details";
    }

    // Example: Admin-only endpoint
    @GetMapping("/admin-only")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminOnly() {
        return "This endpoint is accessible only to ADMIN users";
    }

    // Example: Vendor-only endpoint
    @GetMapping("/vendor-only")
    @PreAuthorize("hasRole('VENDOR')")
    public String vendorOnly() {
        return "This endpoint is accessible only to VENDOR users";
    }

    // Example: Admin OR Vendor endpoint
    @GetMapping("/admin-or-vendor")
    @PreAuthorize("hasRole('ADMIN') or hasRole('VENDOR')")
    public String adminOrVendor() {
        return "This endpoint is accessible to ADMIN or VENDOR users";
    }
}
