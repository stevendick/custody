// Place your Spring DSL code here
beans = {
  tenantResolver(ch.hedgesphere.DomainTenantResolver)
  tenantRepository(ch.hedgesphere.CachingTenantRepository)
}

