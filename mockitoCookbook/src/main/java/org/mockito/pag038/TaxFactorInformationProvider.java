package org.mockito.pag038;

import org.mockito.common.Person;
import org.mockito.pag010.TaxService;

public class TaxFactorInformationProvider {
	private final TaxService taxService;

	public TaxFactorInformationProvider(TaxService taxService) {
		this.taxService = taxService;
	}
	
	public String formatIrsAddress(Person person) {
		String irsAddress = taxService.getInternalRevenueServiceAddress(person.getCountryName());
		return "IRS:[" + irsAddress + "]";
	}
}
