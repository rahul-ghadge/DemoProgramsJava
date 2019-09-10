package com.demo.program.overriding;

class SuperClass
{
    protected void methodOfSuperClass()
    {
        System.out.println("From Super Class");
    }
}

class SubClass extends SuperClass
{

    //private   // Compile time error
    protected   // No issue
    //          // dafault - compile time error
    //public    // No issue



    void methodOfSuperClass()
    {
        //Compile time error, can't reduce visibility of overrided method
        //here, visibility must be protected or public but not private or default
    }
}