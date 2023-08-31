@file:Suppress("OPT_IN_USAGE")

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

kotlin {

    jvm("desktop"){
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
    }

    wasm {
        browser()
    }


    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material3)
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)
            }
        }

        val desktopMain by getting {
            dependencies {
                implementation(compose.desktop.common)
            }
        }

        val nonAndroidMain by creating {
            dependsOn(commonMain)
        }

        val wasmMain by getting {
            dependsOn(nonAndroidMain)
        }

    }



}


compose.experimental {
    web.application {}
}