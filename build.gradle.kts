plugins {
    id("org.jetbrains.kotlin.jvm") version "1.6.21"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.5.21"
    id("org.jetbrains.kotlin.plugin.noarg") version "1.5.21"

    val kotlinVersion = "1.7.0"

    kotlin("kapt") version kotlinVersion
}

noArg {
    annotation("javax.persistence.Entity")
}

allOpen {
    annotation ("javax.persistence.Entity")
    annotation ("javax.persistence.MappedSuperclass")
    annotation ("javax.persistence.Embeddable")
    annotation ("org.springframework.context.annotation.Configuration")
    annotation ("org.springframework.context.annotation.Bean")
}

group = "org.mingble"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val queryDslVersion = "5.0.0"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web:2.7.0")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.7.0")
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    implementation("com.h2database:h2:2.1.210")

    implementation("com.querydsl:querydsl-jpa:$queryDslVersion")
    kapt("com.querydsl:querydsl-apt:$queryDslVersion:jpa")
}

sourceSets["main"].withConvention(org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet::class) {
    kotlin.srcDir("$buildDir/generated/source/kaptDsl/main")
}