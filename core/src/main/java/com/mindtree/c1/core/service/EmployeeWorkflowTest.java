package com.mindtree.c1.core.service;

import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;

@Component(service = WorkflowProcess.class, immediate = true, property = { "process.label" + "=EmployeeWorkflowTest",
		Constants.SERVICE_VENDOR + "=Mindtree", Constants.SERVICE_DESCRIPTION + "=This is a simple workflow process", })
public class EmployeeWorkflowTest implements WorkflowProcess {
	private static final Logger LOG = LoggerFactory.getLogger(EmployeeWorkflowTest.class);

	@Override
	public void execute(WorkItem workItem, WorkflowSession workflowSession, MetaDataMap processArguments)
			throws WorkflowException {
		try {
			String empName = processArguments.get("EMP_NAME", String.class);
			String company = processArguments.get("COMPANY", String.class);
			LOG.info("=======================Employee Details==========================");
			LOG.info("Employee name: " + empName);
			LOG.info("Company: " + company);
			LOG.info("============================================================");

		} catch (Exception e) {
			// TODO: handle exception
			LOG.error("Error: " + e.getMessage());
		}

	}

}


/*
 * CReate a workflow component
 * 
 * create a custom workflow process
 * 
 * Map workflow process with component
 * 
 * Create a design and add the component group in the workflow model
 * 
 * Modify the component group dialog  and some arguments
 * 
 * Write the custom backend code to handle the workflow process
 * 
 * Execute the workflow process
 */
