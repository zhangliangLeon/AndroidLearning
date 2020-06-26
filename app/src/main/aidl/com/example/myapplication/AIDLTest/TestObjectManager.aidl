// TestObjectManager.aidl
package com.example.myapplication.AIDLTest;

import com.example.myapplication.AIDLTest.TestObject;


interface TestObjectManager {
      TestObject getObject();

      void addObject(in TestObject obj);
}
