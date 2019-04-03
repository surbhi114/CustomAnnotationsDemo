# CustomAnnotationsDemo
A short project to understand custom annotations and use reflection to prove annotation existence.
Some pointers about annotations: 
- annotations are Java types that are preceded by an “@” symbol.
- Support added in Jdk 5
- Basically, an annotation assigns extra metadata to the source code it’s bound to. By adding an annotation to a method, interface, class, or field, we can:
- Inform the compiler about warnings and errors
- Manipulate source code at compilation time
- Modify or examine behavior at runtime
- Java Built-in Annotations, which take affect during compilation
1. @Override: indicate that a method overrides an inherited method.
2. @SuppressWarnings: we want to ignore certain warnings from a part of the code.
3. @Deprecated: used to mark an API as not intended for use anymore.
4. @SafeVarargs: acts on a type of warning related to using varargs.
5. @FunctionalInterface: If we intend a SAM interface to be used by lambdas, we can optionally mark it as such with @FunctionalInterface, if the interface is not SAM, the compiler will complain.
- Annotations that apply to other annotations are called meta-annotations. There are several meta-annotation types defined in java.lang.annotation.
1. @Target: to what elements can the annotation be applied
2. @Retention: till what lifecycle of app would the annotation be associated with the annotated class
3. @Inherited: if this annotation should be automatcally be applied to all the sub-classes of annotated class
4. @Documented: if the documentation should appear in java doc
5. @Repeatable: used when we want add same annotation multiple times on a class, we don't have to wrap it inside other annotation anymore

Just do a git clone, run it as java application and enjoy!

Thanks :)

