package com.example;

import org.jetbrains.annotations.NotNull;

import java.util.List;

final class ReplaceConstructorWithFactoryAction {
  void a() {


  }
}

public final class ErrorProneModelSerializerExtension extends JpsModelSerializerExtension {

  private ErrorProneModelSerializerExtension() {
  }

  public static ErrorProneModelSerializerExtension createErrorProneModelSerializerExtension() {
    return new ErrorProneModelSerializerExtension();
  }

  @Override
  public @NotNull List<? extends JpsProjectExtensionSerializer> getProjectExtensionSerializers() {
    return null;
  }
}
