cmake_minimum_required(VERSION 3.30)

# Pull in SDK (must be before project)
include(pico_sdk_import.cmake)

project(pico_fhome C CXX ASM)

set(CMAKE_C_STANDARD 11)
set(CMAKE_CXX_STANDARD 17)

if (PICO_SDK_VERSION_STRING VERSION_LESS "2.1.0")
    message(FATAL_ERROR "Raspberry Pi Pico SDK version 2.1.0 (or later) required. Your version is ${PICO_SDK_VERSION_STRING}")
endif ()

# If you want debug output from USB (pass -DPICO_STDIO_USB=1) this ensures you don't lose any debug output while USB is set up
if (NOT DEFINED PICO_STDIO_USB_CONNECT_WAIT_TIMEOUT_MS)
    set(PICO_STDIO_USB_CONNECT_WAIT_TIMEOUT_MS 3000)
endif ()

# Initialize the SDK
pico_sdk_init()

add_compile_options(-Wall
        -Wno-format          # int != int32_t as far as the compiler is concerned because gcc has int32_t as long int
        -Wno-unused-function # we have some for the docs that aren't called
)
if (CMAKE_C_COMPILER_ID STREQUAL "GNU")
    add_compile_options(-Wno-maybe-uninitialized)
endif ()

include(FetchContent)
FetchContent_Declare(
        pi_pico_lcd
        GIT_REPOSITORY https://github.com/martinkooij/pi-pico-LCD.git
        GIT_TAG V1.2.2
)

FetchContent_Declare(
        json
        GIT_REPOSITORY https://github.com/nlohmann/json.git
        GIT_TAG v3.11.3
)

FetchContent_MakeAvailable(pi_pico_lcd json)

add_subdirectory(${pi_pico_lcd_SOURCE_DIR}/lcd_display ${pi_pico_lcd_BINARY_DIR}/lcd_display)

add_executable(pico_fhome
        main.cpp
)

# pull in common dependencies
target_link_libraries(pico_fhome PUBLIC pico_stdlib nlohmann_json lcd_display)

if (PICO_CYW43_SUPPORTED)
    target_link_libraries(pico_fhome PUBLIC pico_cyw43_arch_none)
endif ()

# create map/bin/hex file etc.
pico_add_extra_outputs(pico_fhome)
