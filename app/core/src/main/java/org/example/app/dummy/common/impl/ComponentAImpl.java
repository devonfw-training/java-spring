package org.example.app.dummy.common.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.example.app.dummy.common.api.ComponentA;
import org.example.app.dummy.common.api.ComponentB;

@Named
public class ComponentAImpl implements ComponentA {

  @Inject
  private ComponentB componentB;

  @Override
  public String greet() {

    return this.componentB.sayHi("World");
  }

}
