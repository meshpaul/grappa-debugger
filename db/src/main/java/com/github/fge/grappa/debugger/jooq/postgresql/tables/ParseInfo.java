/**
 * This class is generated by jOOQ
 */
package com.github.fge.grappa.debugger.jooq.postgresql.tables;

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
public class ParseInfo extends org.jooq.impl.TableImpl<com.github.fge.grappa.debugger.jooq.postgresql.tables.records.ParseInfoRecord> {

	private static final long serialVersionUID = 105598560;

	/**
	 * The reference instance of <code>public.parse_info</code>
	 */
	public static final com.github.fge.grappa.debugger.jooq.postgresql.tables.ParseInfo PARSE_INFO = new com.github.fge.grappa.debugger.jooq.postgresql.tables.ParseInfo();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<com.github.fge.grappa.debugger.jooq.postgresql.tables.records.ParseInfoRecord> getRecordType() {
		return com.github.fge.grappa.debugger.jooq.postgresql.tables.records.ParseInfoRecord.class;
	}

	/**
	 * The column <code>public.parse_info.id</code>.
	 */
	public final org.jooq.TableField<com.github.fge.grappa.debugger.jooq.postgresql.tables.records.ParseInfoRecord, java.util.UUID> ID = createField("id", org.jooq.impl.SQLDataType.UUID.nullable(false), this, "");

	/**
	 * The column <code>public.parse_info.date</code>.
	 */
	public final org.jooq.TableField<com.github.fge.grappa.debugger.jooq.postgresql.tables.records.ParseInfoRecord, java.sql.Timestamp> DATE = createField("date", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

	/**
	 * The column <code>public.parse_info.content</code>.
	 */
	public final org.jooq.TableField<com.github.fge.grappa.debugger.jooq.postgresql.tables.records.ParseInfoRecord, java.lang.String> CONTENT = createField("content", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

	/**
	 * Create a <code>public.parse_info</code> table reference
	 */
	public ParseInfo() {
		this("parse_info", null);
	}

	/**
	 * Create an aliased <code>public.parse_info</code> table reference
	 */
	public ParseInfo(java.lang.String alias) {
		this(alias, com.github.fge.grappa.debugger.jooq.postgresql.tables.ParseInfo.PARSE_INFO);
	}

	private ParseInfo(java.lang.String alias, org.jooq.Table<com.github.fge.grappa.debugger.jooq.postgresql.tables.records.ParseInfoRecord> aliased) {
		this(alias, aliased, null);
	}

	private ParseInfo(java.lang.String alias, org.jooq.Table<com.github.fge.grappa.debugger.jooq.postgresql.tables.records.ParseInfoRecord> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, com.github.fge.grappa.debugger.jooq.postgresql.Public.PUBLIC, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<com.github.fge.grappa.debugger.jooq.postgresql.tables.records.ParseInfoRecord> getPrimaryKey() {
		return com.github.fge.grappa.debugger.jooq.postgresql.Keys.PARSE_INFO_PKEY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<com.github.fge.grappa.debugger.jooq.postgresql.tables.records.ParseInfoRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<com.github.fge.grappa.debugger.jooq.postgresql.tables.records.ParseInfoRecord>>asList(com.github.fge.grappa.debugger.jooq.postgresql.Keys.PARSE_INFO_PKEY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public com.github.fge.grappa.debugger.jooq.postgresql.tables.ParseInfo as(java.lang.String alias) {
		return new com.github.fge.grappa.debugger.jooq.postgresql.tables.ParseInfo(alias, this);
	}

	/**
	 * Rename this table
	 */
	public com.github.fge.grappa.debugger.jooq.postgresql.tables.ParseInfo rename(java.lang.String name) {
		return new com.github.fge.grappa.debugger.jooq.postgresql.tables.ParseInfo(name, null);
	}
}