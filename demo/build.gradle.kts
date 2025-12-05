plugins {
	java
	id("org.springframework.boot") version "4.0.1-SNAPSHOT"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "jumpapp"
version = "0.0.1-SNAPSHOT"
description = "Demo project for Spring Boot"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
	maven { url = uri("https://repo.spring.io/snapshot") }
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-restclient")
	implementation("org.springframework.boot:spring-boot-starter-webmvc")
	compileOnly("org.projectlombok:lombok")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-restclient-test")
	testImplementation("org.springframework.boot:spring-boot-starter-webmvc-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.16.1") // Check for latest version
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.16.1")
    implementation("org.springframework.boot:spring-boot-starter-cache")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
