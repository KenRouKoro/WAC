plugins {
    id("mod.base-conventions")
    id("java")
}
apply(from = File("../commonsettings.gradle"))

val ProjectVersion: String by extra

group = "cn.korostudio.mc.wac"
version = ProjectVersion

repositories {
  mavenCentral()
  mavenLocal()
}
dependencies {
    implementation(libs.ignite)
    implementation(libs.mixin)

    paperweight.paperDevBundle("1.19.3-R0.1-SNAPSHOT")
    implementation(project(":WACCommon"))
    implementation("cn.hutool:hutool-all:5.8.16")
}
