package org.checkerframework.checker.signedness.qual;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.checkerframework.framework.qual.SubtypeOf;

/**
 * Represents values that are not arithmetic quantities, but are manipulated as a pattern of bits.
 * Examples include:
 * <ul>
 *   <li>The return value of {@link Double#doubleToLongBits(double)}</li>
 *   <li>Values used as bitsets</li>
 *   <li>Hash codes or other bit-encoded values</li>
 * </ul>
 *
 * <p>This annotation indicates that a value should be treated as a bit pattern rather than as a
 * signed or unsigned number. Bitwise operations (such as {@code &}, {@code |}, {@code ^}, {@code <<},
 * {@code >>}, {@code >>>}) are permitted on {@code @BitPattern} values, but arithmetic operations
 * (such as {@code +}, {@code -}, {@code *}, {@code /}, {@code %}, comparison operators) are forbidden.
 *
 * <p>In the type hierarchy:
 * <ul>
 *   <li>{@code @BitPattern} is a subtype of {@code @UnknownSignedness}</li>
 *   <li>{@code @BitPattern} is a supertype of {@code @SignednessBottom}</li>
 *   <li>{@code @BitPattern} is unrelated to {@code @Signed}, {@code @Unsigned}, and {@code @SignedPositive}</li>
 * </ul>
 *
 * @see org.checkerframework.checker.signedness.SignednessChecker
 * @checker_framework.manual #signedness-checker Signedness Checker
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
@SubtypeOf(UnknownSignedness.class)
public @interface BitPattern {}
