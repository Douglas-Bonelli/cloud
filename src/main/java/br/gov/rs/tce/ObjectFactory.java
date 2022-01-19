//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.3.2 
// Consulte <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2022.01.19 às 04:44:43 PM BRT 
//


package br.gov.rs.tce;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.gov.rs.tce package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.gov.rs.tce
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetOrgaoDetailRequest }
     * 
     */
    public GetOrgaoDetailRequest createGetOrgaoDetailRequest() {
        return new GetOrgaoDetailRequest();
    }

    /**
     * Create an instance of {@link GetOrgaoDetailResponse }
     * 
     */
    public GetOrgaoDetailResponse createGetOrgaoDetailResponse() {
        return new GetOrgaoDetailResponse();
    }

    /**
     * Create an instance of {@link OrgaoDetail }
     * 
     */
    public OrgaoDetail createOrgaoDetail() {
        return new OrgaoDetail();
    }

}
