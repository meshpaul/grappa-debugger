/**
 * This class is generated by jOOQ
 */
package com.github.fge.grappa.debugger.postgresql.jooq.tables;

import com.github.fge.grappa.debugger.postgresql.jooq.Keys;
import com.github.fge.grappa.debugger.postgresql.jooq.Public;
import com.github.fge.grappa.debugger.postgresql.jooq.tables.records
	.NodesRecord;

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
public class Nodes extends org.jooq.impl.TableImpl<NodesRecord> {

	private static final long serialVersionUID = -1629815031;

	/**
	 * The reference instance of <code>public.nodes</code>
	 */
	public static final Nodes NODES = new Nodes();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<NodesRecord> getRecordType() {
		return NodesRecord.class;
	}

	/**
	 * The column <code>public.nodes.parse_info_id</code>.
	 */
	public final org.jooq.TableField<NodesRecord, java.util.UUID> PARSE_INFO_ID = createField("parse_info_id", org.jooq.impl.SQLDataType.UUID, this, "");

	/**
	 * The column <code>public.nodes.id</code>.
	 */
	public final org.jooq.TableField<NodesRecord, java.lang.Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>public.nodes.parent_id</code>.
	 */
	public final org.jooq.TableField<NodesRecord, java.lang.Integer> PARENT_ID = createField("parent_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>public.nodes.level</code>.
	 */
	public final org.jooq.TableField<NodesRecord, java.lang.Integer> LEVEL = createField("level", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>public.nodes.success</code>.
	 */
	public final org.jooq.TableField<NodesRecord, java.lang.Integer> SUCCESS = createField("success", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>public.nodes.matcher_id</code>.
	 */
	public final org.jooq.TableField<NodesRecord, java.lang.Integer> MATCHER_ID = createField("matcher_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>public.nodes.start_index</code>.
	 */
	public final org.jooq.TableField<NodesRecord, java.lang.Integer> START_INDEX = createField("start_index", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>public.nodes.end_index</code>.
	 */
	public final org.jooq.TableField<NodesRecord, java.lang.Integer> END_INDEX = createField("end_index", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>public.nodes.time</code>.
	 */
	public final org.jooq.TableField<NodesRecord, java.lang.Long> TIME = createField("time", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

	/**
	 * Create a <code>public.nodes</code> table reference
	 */
	public Nodes() {
		this("nodes", null);
	}

	/**
	 * Create an aliased <code>public.nodes</code> table reference
	 */
	public Nodes(java.lang.String alias) {
		this(alias, Nodes.NODES);
	}

	private Nodes(java.lang.String alias, org.jooq.Table<NodesRecord> aliased) {
		this(alias, aliased, null);
	}

	private Nodes(java.lang.String alias, org.jooq.Table<NodesRecord> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, Public.PUBLIC, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<NodesRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<NodesRecord>>asList(
			Keys.NODES_PARSE_INFO_ID_ID_KEY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.ForeignKey<NodesRecord, ?>> getReferences() {
		return java.util.Arrays.<org.jooq.ForeignKey<NodesRecord, ?>>asList(
			Keys.NODES__NODES_PARSE_INFO_ID_FKEY, Keys.NODES__NODES_PARSE_INFO_ID_FKEY1);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Nodes as(java.lang.String alias) {
		return new Nodes(alias, this);
	}

	/**
	 * Rename this table
	 */
	public Nodes rename(java.lang.String name) {
		return new Nodes(name, null);
	}
}