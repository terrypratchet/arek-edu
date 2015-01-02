package com.arek;

import java.util.Arrays;
import java.util.Set;
import java.util.TimeZone;

import net.fortuna.ical4j.model.TimeZoneRegistry;
import net.fortuna.ical4j.model.TimeZoneRegistryFactory;

import org.joda.time.DateTimeZone;

import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;

public class TimeZones {

	public static void main(String[] args) {
		
		
		Set<String> jodaZones = jodaZones();
		Set<String> sunTimeZones = sunTimeZones();
		Set<String> icalZones = icalZones();
		
		System.out.println("jodaZones: " + jodaZones.size());
		System.out.println("sunTime: " + sunTimeZones.size());
		System.out.println("ical:" + icalZones.size());
		
		SetView<String> joda_sun = Sets.difference(jodaZones, sunTimeZones);
		SetView<String> sun_joda = Sets.difference(sunTimeZones, jodaZones);
		SetView<String> ical_sun = Sets.difference(icalZones, sunTimeZones);
	
		
		
		System.out.println("____________joda - sun: ");
		for( String tz : joda_sun ){
			System.out.println("" + tz);
		}
		
		
		System.out.println("_____________sun - joda: ");
		for( String tz: sun_joda){
			System.out.println("" + tz);
		}
		
		
		System.out.println("_____________ical - sun: ");
		for( String tz: ical_sun){
			System.out.println("" + tz);
		}
		
		testIcal();
	
	}

	private static Set<String> jodaZones() {
		return DateTimeZone.getAvailableIDs();


	}

	private static Set<String> sunTimeZones() {
		String[] availableIDs = TimeZone.getAvailableIDs();
		Arrays.sort(availableIDs);
		return Sets.newHashSet(availableIDs);
		
	}
	
	private static Set<String> icalZones(){
		String availableIDs[] = net.fortuna.ical4j.model.TimeZone.getAvailableIDs();
		Arrays.sort(availableIDs);
		return Sets.newHashSet(availableIDs);
	}
	
	private static void testIcal(){
		String tzs = "BSTs";
		TimeZone tz = net.fortuna.ical4j.model.TimeZone.getTimeZone(tzs);
		System.out.println("tz: " + tz);
		TimeZoneRegistry registry = TimeZoneRegistryFactory.getInstance().createRegistry();
		net.fortuna.ical4j.model.TimeZone icalTz  = registry.getTimeZone(tzs);
		icalTz.getVTimeZone();
		
		
		
	}

}
