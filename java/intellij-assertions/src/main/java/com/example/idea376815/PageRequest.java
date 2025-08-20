package com.example.idea376815;

import java.awt.print.PageFormat;
import java.awt.print.Pageable;
import java.awt.print.Printable;
import java.io.Serial;
import java.io.Serializable;

public record PageRequest(int page) implements Pageable, Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  @Override
  public int getNumberOfPages() {
    return 0;
  }

  @Override
  public PageFormat getPageFormat(int pageIndex) throws IndexOutOfBoundsException {
    return null;
  }

  @Override
  public Printable getPrintable(int pageIndex) throws IndexOutOfBoundsException {
    return null;
  }
}
