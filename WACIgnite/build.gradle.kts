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
  maven("https://jitpack.io")
}
dependencies {
    implementation(libs.ignite)
    implementation(libs.mixin)

    paperweight.paperDevBundle("1.20.1-R0.1-SNAPSHOT")
    implementation(project(":WACCommon"))
    implementation("cn.hutool:hutool-all:5.8.16")
}
