import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.7.4"
	id("io.spring.dependency-management") version "1.1.0"
	kotlin("jvm") version "1.7.22"
	kotlin("plugin.spring") version "1.7.22"
}

group = "io.quillio"
version = "1.0.0"
java.sourceCompatibility = JavaVersion.VERSION_1_8

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-webflux")
	implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

	// auth
	implementation("org.springframework.boot:spring-boot-starter-security")

	// reactor
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
	implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")

	// lombok
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")

	implementation("com.github.jasync-sql:jasync-r2dbc-mysql:2.1.1")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")

	implementation ("me.paulschwarz:spring-dotenv:2.5.4")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("io.projectreactor:reactor-test")
}


