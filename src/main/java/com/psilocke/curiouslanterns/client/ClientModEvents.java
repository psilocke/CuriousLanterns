package com.psilocke.curiouslanterns.client;

import com.psilocke.curiouslanterns.CuriousLanterns;
import com.psilocke.curiouslanterns.curios.LanternRenderer;
import com.psilocke.curiouslanterns.curios.MediumLanternRenderer;
import com.psilocke.curiouslanterns.curios.LargeLanternRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ForgeModelBakery;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;

@Mod.EventBusSubscriber(modid = CuriousLanterns.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientModEvents {
	
	@SubscribeEvent
	public static void onClientSetupEvent(FMLClientSetupEvent e) {
		
		//normal lantern mods
		
		for(String var : CuriousLanterns.lanterns) {
			String namespace = var.substring(0, var.indexOf(':'));
			String item = var.substring(var.indexOf(':')+1);
			
			if(ModList.get().isLoaded(namespace)) {
				CuriosRendererRegistry.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(namespace, item)), LanternRenderer::new);
			}
		}
		
		//for medium lanterns
		
		for(String var : CuriousLanterns.medium_lanterns) {
			String namespace = var.substring(0, var.indexOf(':'));
			String item = var.substring(var.indexOf(':')+1);
			
			if(ModList.get().isLoaded(namespace)) {
				CuriosRendererRegistry.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(namespace, item)), MediumLanternRenderer::new);
			}
		}

		//for larger lanterns
		
		for(String var : CuriousLanterns.large_lanterns) {
			String namespace = var.substring(0, var.indexOf(':'));
			String item = var.substring(var.indexOf(':')+1);
			
			if(ModList.get().isLoaded(namespace)) {
				CuriosRendererRegistry.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(namespace, item)), LargeLanternRenderer::new);
			}
		}
		
		//additional lanterns because of fricking course
		if(ModList.get().isLoaded("additionallanterns")) {
			for(String color : CuriousLanterns.lan_colors) {
				for(String material : CuriousLanterns.lan_materials) {
					String name = color;
					if(name == CuriousLanterns.lan_colors[0]) {
						name += material;
					}else name += ("_" + material);
					
					CuriosRendererRegistry.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation("additionallanterns", name+"_lantern")), LanternRenderer::new);
				}
			}
		}
		
		/*
		//for skinned lanterns *sigh* (does not work)

		if(ModList.get().isLoaded("skinnedlanterns")) {
			for(String name : CuriousLanterns.skinned_lanterns) {
				if(name == "paper" || name == "ornament") {
					for (String color : CuriousLanterns.lan_colors) {
						if(color == "") {
							continue;
						}
						CuriosRendererRegistry.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation("skinnedlanterns", name + "_" + color + "_lantern_block")), LargeLanternRenderer::new);
						CuriosRendererRegistry.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation("skinnedlanterns", name + "_" + color + "_soul_lantern_block")), LargeLanternRenderer::new);
					}
				}else {
					CuriosRendererRegistry.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation("skinnedlanterns", name + "_lantern_block")), LargeLanternRenderer::new);
					CuriosRendererRegistry.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation("skinnedlanterns", name + "_soul_lantern_block")), LargeLanternRenderer::new);
				}
			}
		}
		*/
	}
	
	@SubscribeEvent
	public static void onModelregister(ModelRegistryEvent event) {
		
		//normal lantern mods
		
		for(String var : CuriousLanterns.lanterns) {
			String namespace = var.substring(0, var.indexOf(':'));
			String item = var.substring(var.indexOf(':')+1);
			
			if(ModList.get().isLoaded(namespace)) {
				ForgeModelBakery.addSpecialModel(new ResourceLocation(namespace, "block/" + item));
			}
		}

		//for medium lanterns
		
		for(String var : CuriousLanterns.medium_lanterns) {
			String namespace = var.substring(0, var.indexOf(':'));
			String item = var.substring(var.indexOf(':')+1);
			
			if(ModList.get().isLoaded(namespace)) {
				ForgeModelBakery.addSpecialModel(new ResourceLocation(namespace, "block/" + item));
			}
		}
		
		//for larger lanterns
		
		for(String var : CuriousLanterns.large_lanterns) {
			String namespace = var.substring(0, var.indexOf(':'));
			String item = var.substring(var.indexOf(':')+1);
			
			if(ModList.get().isLoaded(namespace)) {
				ForgeModelBakery.addSpecialModel(new ResourceLocation(namespace, "block/" + item));
			}
		}
		
		//additional lanterns because of fricking course
		if(ModList.get().isLoaded("additionallanterns")) {
			for(String color : CuriousLanterns.lan_colors) {
				for(String material : CuriousLanterns.lan_materials) {
					String name = color;
					if(name == CuriousLanterns.lan_colors[0]) {
						name += material;
					}else name += ("_" + material);
					
					ForgeModelBakery.addSpecialModel(new ResourceLocation("additionallanterns", "block/" + name+ "_lantern"));
				}
			}
		}
		
		/*
		//for skinned lanterns *sigh* (does not work)

		if(ModList.get().isLoaded("skinnedlanterns")) {
			for(String name : CuriousLanterns.skinned_lanterns) {
				if(name == "paper" || name == "ornament") {
					for (String color : CuriousLanterns.lan_colors) {
						if(color == "") {
							continue;
						}
						ForgeModelBakery.addSpecialModel(new ResourceLocation("skinnedlanterns", "block/" + name + "_" + color + "_lantern_block"));
						ForgeModelBakery.addSpecialModel(new ResourceLocation("skinnedlanterns", "block/" + name + "_" + color + "_soul_lantern_block"));
					}
				}else {
					ForgeModelBakery.addSpecialModel(new ResourceLocation("skinnedlanterns", "block/" + name + "_lantern_block"));
					ForgeModelBakery.addSpecialModel(new ResourceLocation("skinnedlanterns", "block/" + name + "_soul_lantern_block"));
				}
			}
		}
		*/
	}
}