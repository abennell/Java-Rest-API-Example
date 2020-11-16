package org.alex.showroom.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.alex.showroom.hibernate.entities.BrandEntity;
import org.alex.showroom.services.BrandsService;

@Path("/showroom")
public class Brands {
	BrandsService brandsService = new BrandsService();

	@GET
	@Path("/brands")
	@Produces(MediaType.APPLICATION_JSON)
	public List<BrandEntity> getBrands() {
		List<BrandEntity> list = brandsService.getBrands();
		return list;
	}

	@POST
	@Path("/brands")
	@Consumes(MediaType.APPLICATION_JSON)
	public void postBrands(BrandEntity brand) {
		brandsService.addBrand(brand);

	}

	@PUT
	@Path("/brands/{brandId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateBrands(@PathParam("brandId") int brandId, BrandEntity updatedBrand) {
		updatedBrand.setBrandId(brandId);
		brandsService.updatedBrand(updatedBrand);
	}

	@DELETE
	@Path("/brands/{brandId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteBrands(@PathParam("brandId") int brandId) {
		brandsService.deleteBrand(brandId);
	}

}
