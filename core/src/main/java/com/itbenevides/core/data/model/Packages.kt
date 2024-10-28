package com.itbenevides.core.data.model

data class Packages(
    val packageGroup: Package,
    val packages: List<Package>,
    val resumePackages: List<ResumePackages>,
    val status: List<Status>
)
