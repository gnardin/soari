
/**
 * MapperServerWebServiceImplCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4  Built on : Apr 26, 2008 (06:24:30 EDT)
 */

    package otservices.mapper.webservice;

    /**
     *  MapperServerWebServiceImplCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class MapperServerWebServiceImplCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public MapperServerWebServiceImplCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public MapperServerWebServiceImplCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for translateConcept method
            * override this method for handling normal response from translateConcept operation
            */
           public void receiveResulttranslateConcept(
                    otservices.mapper.webservice.MapperServerWebServiceImplStub.TranslateConceptResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from translateConcept operation
           */
            public void receiveErrortranslateConcept(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getFromMapping method
            * override this method for handling normal response from getFromMapping operation
            */
           public void receiveResultgetFromMapping(
                    otservices.mapper.webservice.MapperServerWebServiceImplStub.GetFromMappingResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getFromMapping operation
           */
            public void receiveErrorgetFromMapping(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getOWLFile method
            * override this method for handling normal response from getOWLFile operation
            */
           public void receiveResultgetOWLFile(
                    otservices.mapper.webservice.MapperServerWebServiceImplStub.GetOWLFileResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getOWLFile operation
           */
            public void receiveErrorgetOWLFile(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for removeOntologyTranslation method
            * override this method for handling normal response from removeOntologyTranslation operation
            */
           public void receiveResultremoveOntologyTranslation(
                    otservices.mapper.webservice.MapperServerWebServiceImplStub.RemoveOntologyTranslationResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from removeOntologyTranslation operation
           */
            public void receiveErrorremoveOntologyTranslation(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addOntologyTranslation method
            * override this method for handling normal response from addOntologyTranslation operation
            */
           public void receiveResultaddOntologyTranslation(
                    otservices.mapper.webservice.MapperServerWebServiceImplStub.AddOntologyTranslationResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addOntologyTranslation operation
           */
            public void receiveErroraddOntologyTranslation(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for isOntologyTranslation method
            * override this method for handling normal response from isOntologyTranslation operation
            */
           public void receiveResultisOntologyTranslation(
                    otservices.mapper.webservice.MapperServerWebServiceImplStub.IsOntologyTranslationResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from isOntologyTranslation operation
           */
            public void receiveErrorisOntologyTranslation(java.lang.Exception e) {
            }
                


    }
    