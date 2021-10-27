package com.havuzentity.havuzentitty.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class AdsressUpdateDTO implements Serializable{


	private static final long serialVersionUID = 1L;

	@NotNull(message = "{backend.validation.constraints.address.NotNull.message}")
	@Size(min = 2, max = 70, message = "{backend.validation.constraints.address.Size.message}")
	private String address;

	@NotNull(message = "{backend.validation.constraints.address.NotNull.message}")
	@Size(min = 2, max = 70, message = "{backend.validation.constraints.address.Size.message}")
	private String street;

	@NotNull(message ="{backend.validation.constraints.address.NotNull.message}")
	@Size(min=2, max=70, message = "{backend.validation.constraints.address.Size.message}")
	private String neighborhood;

	@NotNull(message ="{backend.validation.constraints.address.NotNull.message}")
	@Size(min=2, max=70, message = "{backend.validation.constraints.address.Size.message}")
	private String district;

	@NotNull(message ="{backend.validation.constraints.address.NotNull.message}")
	@Size(min=2, max=70, message = "{backend.validation.constraints.address.Size.message}")
	private String city;

}
