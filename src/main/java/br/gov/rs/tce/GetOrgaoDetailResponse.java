//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.3.2 
// Consulte <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2022.01.19 às 04:44:43 PM BRT 
//


package br.gov.rs.tce;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de anonymous complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="OrgaoDetail" type="{http://tce.rs.gov.br}OrgaoDetail"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "orgaoDetail"
})
@XmlRootElement(name = "GetOrgaoDetailResponse")
public class GetOrgaoDetailResponse {

    @XmlElement(name = "OrgaoDetail", required = true)
    protected OrgaoDetail orgaoDetail;

    /**
     * Obtém o valor da propriedade orgaoDetail.
     * 
     * @return
     *     possible object is
     *     {@link OrgaoDetail }
     *     
     */
    public OrgaoDetail getOrgaoDetail() {
        return orgaoDetail;
    }

    /**
     * Define o valor da propriedade orgaoDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link OrgaoDetail }
     *     
     */
    public void setOrgaoDetail(OrgaoDetail value) {
        this.orgaoDetail = value;
    }

}
