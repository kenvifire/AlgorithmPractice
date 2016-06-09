cmake_minimum_required(VERSION 3.5)
project(cpp)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(SOURCE_FILES main.cpp)
add_executable(cpp ${SOURCE_FILES})
add_executable(matrix matrix.cpp)
add_executable(viriableSizedArray VariableSizedArrays.cpp)
add_executable(complex Complex.cpp)
add_executable(virtualfunctions virtualfunctions.cpp)
add_executable(bitset bitset.cpp)