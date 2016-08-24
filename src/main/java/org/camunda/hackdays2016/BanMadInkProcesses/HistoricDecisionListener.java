package org.camunda.hackdays2016.BanMadInkProcesses;

import java.net.InetAddress;
import java.util.logging.Logger;

import org.camunda.bpm.engine.HistoryService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.camunda.bpm.engine.history.HistoricDecisionInstance;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

import com.fasterxml.jackson.databind.ObjectMapper;


public class HistoricDecisionListener implements ExecutionListener {

	protected static final Logger LOGGER = Logger.getLogger(HistoricDecisionListener.class.getName());
	
	@Override
	public void notify(DelegateExecution execution) throws Exception {

		HistoryService historyService = execution.getProcessEngineServices().getHistoryService();
		
		HistoricDecisionInstance historicDecisionInstance = historyService.createHistoricDecisionInstanceQuery()
																	.includeInputs()
																	.includeOutputs()
																	.decisionDefinitionKey((String)execution.getVariableLocal("tableName"))
																	.processInstanceId(execution.getProcessInstanceId())
																	.singleResult();
	
		
		ObjectMapper mapper = new ObjectMapper();

		String serializedHistoricDecisionInstance = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(historicDecisionInstance);
			
		
		Client client = TransportClient.builder().build()
		        .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));

		
		IndexResponse response = client.prepareIndex("camunda", "historicDecision", historicDecisionInstance.getId())
		        .setSource(serializedHistoricDecisionInstance)
		        .get();
		
		LOGGER.info(response.getId());
		
	}

}
