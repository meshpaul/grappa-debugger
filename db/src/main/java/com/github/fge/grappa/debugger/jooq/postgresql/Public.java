/**
 * This class is generated by jOOQ
 */
package com.github.fge.grappa.debugger.jooq.postgresql;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.5.4"
	},
	comments = "This class is generated by jOOQ"
)
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Public extends org.jooq.impl.SchemaImpl {

	private static final long serialVersionUID = 1433496048;

	/**
	 * The reference instance of <code>public</code>
	 */
	public static final Public PUBLIC = new Public();

	/**
	 * No further instances allowed
	 */
	private Public() {
		super("public");
	}

	@Override
	public final java.util.List<org.jooq.Table<?>> getTables() {
		java.util.List result = new java.util.ArrayList();
		result.addAll(getTables0());
		return result;
	}

	private final java.util.List<org.jooq.Table<?>> getTables0() {
		return java.util.Arrays.<org.jooq.Table<?>>asList(
			com.github.fge.grappa.debugger.jooq.postgresql.tables.Matchers.MATCHERS,
			com.github.fge.grappa.debugger.jooq.postgresql.tables.Nodes.NODES,
			com.github.fge.grappa.debugger.jooq.postgresql.tables.ParseInfo.PARSE_INFO);
	}
}