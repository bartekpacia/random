import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

/**
 * A custom meta-annotation that other annotations can be annotated with.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
@interface MyMetaAnnotation {
}

/**
 * An annotation that uses MyMetaAnnotation.
 */
@MyMetaAnnotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface FirstAnnotation {
}

/**
 * Another annotation that uses MyMetaAnnotation.
 */
@MyMetaAnnotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface SecondAnnotation {
}

/**
 * A third annotation that uses MyMetaAnnotation.
 */
@MyMetaAnnotation
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@interface ThirdAnnotation {
}

/**
 * A regular class (not an annotation) - should NOT appear in subtypes.
 */
@FirstAnnotation
class RegularClass {
}
