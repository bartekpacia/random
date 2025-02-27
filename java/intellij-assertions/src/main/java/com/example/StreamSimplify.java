package com.example;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamSimplify {
  String bar(Map<String, List<Integer>> map) {
    // Map is Map<String, List<Integer>>
    // entrySet is Set<Entry<String, List<Integer>>> -> integers
    // keySet() is Set<String>

    var a = map.entrySet().stream()
      .map(entry -> entry.getKey() + "!")
      .collect(Collectors.joining());

    var b = map.entrySet().stream()
      .map(entry -> entry.getKey() + "!")
      .collect(Collectors.joining());

    return a;
  }

  void test(Map<Object, List<Integer>> map) {
    String str = map.entrySet().stream()
      .map(entry -> entry.getKey() + ", ")
      .collect(Collectors.joining());
  }
}
