databaseChangeLog = {
    
    changeSet(author: 'sdick', id: '1348750803384-1') {
        
        addColumn(tableName: 'trade') {
            column(name: 'settle_date', type: 'date') {
                constraints(nullable: 'true')
            }
        }
        
        sql() {
            'update trade set settleDate = date'
        }
        
        addNotNullConstraint(tableName: 'trade', columnDataType: 'date', columnName: 'settle_date')
    }
}

