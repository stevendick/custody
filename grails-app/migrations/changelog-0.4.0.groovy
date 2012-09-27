databaseChangeLog = {

	changeSet(author: "sdick (generated)", id: "1348749428854-1") {
		createTable(tableName: "customer") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "customerPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "sdick (generated)", id: "1348749428854-2") {
		createTable(tableName: "role") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "rolePK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "sdick (generated)", id: "1348749428854-3") {
		createTable(tableName: "role_permissions") {
			column(name: "role_id", type: "bigint")

			column(name: "permissions_string", type: "varchar(255)")
		}
	}

	changeSet(author: "sdick (generated)", id: "1348749428854-4") {
		createTable(tableName: "trade") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "tradePK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "account", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "amount", type: "decimal(19,2)") {
				constraints(nullable: "false")
			}

			column(name: "bank_account_type", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "date", type: "date") {
				constraints(nullable: "false")
			}

			column(name: "nav", type: "decimal(19,2)") {
				constraints(nullable: "false")
			}

			column(name: "security", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "shares", type: "decimal(19,2)") {
				constraints(nullable: "false")
			}

			column(name: "tenant_id", type: "integer") {
				constraints(nullable: "false")
			}

			column(name: "transaction_type", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "sdick (generated)", id: "1348749428854-5") {
		createTable(tableName: "user") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "userPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "password_hash", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "username", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "sdick (generated)", id: "1348749428854-6") {
		createTable(tableName: "user_permissions") {
			column(name: "user_id", type: "bigint")

			column(name: "permissions_string", type: "varchar(255)")
		}
	}

	changeSet(author: "sdick (generated)", id: "1348749428854-7") {
		createTable(tableName: "user_roles") {
			column(name: "user_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "role_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "sdick (generated)", id: "1348749428854-8") {
		addPrimaryKey(columnNames: "user_id, role_id", tableName: "user_roles")
	}

	changeSet(author: "sdick (generated)", id: "1348749428854-9") {
		addForeignKeyConstraint(baseColumnNames: "role_id", baseTableName: "role_permissions", constraintName: "FKEAD9D23BBE136EBF", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "role", referencesUniqueColumn: "false")
	}

	changeSet(author: "sdick (generated)", id: "1348749428854-10") {
		addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "user_permissions", constraintName: "FKE693E610633E329F", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}

	changeSet(author: "sdick (generated)", id: "1348749428854-11") {
		addForeignKeyConstraint(baseColumnNames: "role_id", baseTableName: "user_roles", constraintName: "FK73429949BE136EBF", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "role", referencesUniqueColumn: "false")
	}

	changeSet(author: "sdick (generated)", id: "1348749428854-12") {
		addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "user_roles", constraintName: "FK73429949633E329F", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}

	changeSet(author: "sdick (generated)", id: "1348749428854-13") {
		createIndex(indexName: "name_unique_1348749428800", tableName: "customer", unique: "true") {
			column(name: "name")
		}
	}

	changeSet(author: "sdick (generated)", id: "1348749428854-14") {
		createIndex(indexName: "name_unique_1348749428802", tableName: "role", unique: "true") {
			column(name: "name")
		}
	}

	changeSet(author: "sdick (generated)", id: "1348749428854-15") {
		createIndex(indexName: "username_unique_1348749428794", tableName: "user", unique: "true") {
			column(name: "username")
		}
	}
}
