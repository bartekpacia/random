cmake_minimum_required(VERSION 4.0)
project(untitled1 C)

set(CMAKE_C_STANDARD 11)

add_executable(main_old main_old.c)

include(FetchContent)
FetchContent_Declare(
        unity
        GIT_REPOSITORY https://github.com/ThrowTheSwitch/Unity.git
        GIT_TAG v2.6.1
)
FetchContent_MakeAvailable(unity)

# Create a library from your code that you want to test
add_library(mycode STATIC main.c)
# Compile the library with TESTING so the main() in main.c is excluded from the lib
target_compile_definitions(mycode PRIVATE TESTING)

# Your main executable
add_executable(main main.c)

# Test executable
enable_testing()
add_executable(test_runner test_main.c)
target_link_libraries(test_runner unity mycode)
add_test(NAME test_runner COMMAND test_runner)
