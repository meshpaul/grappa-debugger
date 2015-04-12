/**
 * This class is generated by jOOQ
 */
package com.github.fge.grappa.debugger.h2.jooq;

import com.github.fge.grappa.debugger.h2.jooq.tables.Matchers;
import com.github.fge.grappa.debugger.h2.jooq.tables.Nodes;
import com.github.fge.grappa.debugger.h2.jooq.tables.records.MatchersRecord;
import com.github.fge.grappa.debugger.h2.jooq.tables.records.NodesRecord;
import org.jooq.impl.AbstractKeys;

/**
 * A class modelling foreign key relationships between tables of the <code>PUBLIC</code> 
 * schema
 */
@javax.annotation.Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.5.4"
	},
	comments = "This class is generated by jOOQ"
)
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

	// -------------------------------------------------------------------------
	// IDENTITY definitions
	// -------------------------------------------------------------------------


	// -------------------------------------------------------------------------
	// UNIQUE and PRIMARY KEY definitions
	// -------------------------------------------------------------------------

	public static final org.jooq.UniqueKey<MatchersRecord> CONSTRAINT_4 = UniqueKeys0.CONSTRAINT_4;
	public static final org.jooq.UniqueKey<NodesRecord> CONSTRAINT_47 = UniqueKeys0.CONSTRAINT_47;

	// -------------------------------------------------------------------------
	// FOREIGN KEY definitions
	// -------------------------------------------------------------------------

	public static final org.jooq.ForeignKey<NodesRecord, MatchersRecord> CONSTRAINT_470 = ForeignKeys0.CONSTRAINT_470;

	// -------------------------------------------------------------------------
	// [#1459] distribute members to avoid static initialisers > 64kb
	// -------------------------------------------------------------------------

	private static class UniqueKeys0 extends org.jooq.impl.AbstractKeys {
		public static final org.jooq.UniqueKey<MatchersRecord> CONSTRAINT_4 = createUniqueKey(
			Matchers.MATCHERS, Matchers.MATCHERS.ID);
		public static final org.jooq.UniqueKey<NodesRecord> CONSTRAINT_47 = createUniqueKey(
			Nodes.NODES, Nodes.NODES.ID);
	}

	private static class ForeignKeys0 extends org.jooq.impl.AbstractKeys {
		public static final org.jooq.ForeignKey<NodesRecord, MatchersRecord> CONSTRAINT_470 = AbstractKeys

			.createForeignKey(Keys.CONSTRAINT_4, Nodes.NODES,
				Nodes.NODES.MATCHER_ID);
	}
}
