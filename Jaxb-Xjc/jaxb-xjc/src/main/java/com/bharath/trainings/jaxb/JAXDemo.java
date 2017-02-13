package com.bharath.trainings.jaxb;

import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.bharatthippireddy.patient.Patient;

public class JAXDemo {
	public static void main(String[] args) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(Patient.class);
		Marshaller marshaller = context.createMarshaller();
		
		Patient patient = new Patient();
		patient.setId(123);
		patient.setName("Bharath");
		
		StringWriter writer = new StringWriter();
		marshaller.marshal(patient, writer);
		
		System.out.println(writer.toString());
		
		Unmarshaller unMarshaller = context.createUnmarshaller();
		Patient patientResult = (Patient) unMarshaller.unmarshal(new StringReader(writer.toString()));
		System.out.println(patientResult.getName());
	}
}
