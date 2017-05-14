package annotations;


public @interface SimulatingNull {
	
	public int id() default -1;
	public String description() default "";
}
