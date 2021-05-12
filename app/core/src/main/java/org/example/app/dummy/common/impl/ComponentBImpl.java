package org.example.app.dummy.common.impl;

import javax.inject.Named;

import org.example.app.dummy.common.api.ComponentB;

@Named
public class ComponentBImpl implements ComponentB {

  @Override
  public String sayHi(String name) {

    return "Hello " + name;
  }

}
