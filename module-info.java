/**
 * Java 2D Graphics Demo 2, JOGL OpenGL Project Program purpose: This program
 * presents 3 graphics composed of OpenGL graphic components using
 * transformation methods.
 * 
 * ** NOTE ** A module is necessary to access the jogl classes.
 * 
 * @author ReynaldoSantos
 */

module mod.java2dmain2 {
    requires java.desktop;
    requires jogl.all;
    requires jogl.all.natives.windows.amd64;

    requires gluegen.rt;
    requires gluegen.rt.natives.windows.amd64;
}