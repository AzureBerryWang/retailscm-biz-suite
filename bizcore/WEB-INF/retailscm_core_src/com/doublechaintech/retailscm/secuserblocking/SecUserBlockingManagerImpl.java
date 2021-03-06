
package com.doublechaintech.retailscm.secuserblocking;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.BaseEntity;


import com.doublechaintech.retailscm.Message;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;

import com.doublechaintech.retailscm.RetailscmUserContext;
//import com.doublechaintech.retailscm.BaseManagerImpl;
import com.doublechaintech.retailscm.RetailscmCheckerManager;
import com.doublechaintech.retailscm.CustomRetailscmCheckerManager;

import com.doublechaintech.retailscm.secuser.SecUser;


import com.doublechaintech.retailscm.secuserblocking.SecUserBlocking;
import com.doublechaintech.retailscm.userdomain.UserDomain;






public class SecUserBlockingManagerImpl extends CustomRetailscmCheckerManager implements SecUserBlockingManager {
	
	private static final String SERVICE_TYPE = "SecUserBlocking";
	@Override
	public SecUserBlockingDAO daoOf(RetailscmUserContext userContext) {
		return secUserBlockingDaoOf(userContext);
	}
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws SecUserBlockingManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new SecUserBlockingManagerException(message);

	}
	
	

 	protected SecUserBlocking saveSecUserBlocking(RetailscmUserContext userContext, SecUserBlocking secUserBlocking, String [] tokensExpr) throws Exception{	
 		//return getSecUserBlockingDAO().save(secUserBlocking, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveSecUserBlocking(userContext, secUserBlocking, tokens);
 	}
 	
 	protected SecUserBlocking saveSecUserBlockingDetail(RetailscmUserContext userContext, SecUserBlocking secUserBlocking) throws Exception{	

 		
 		return saveSecUserBlocking(userContext, secUserBlocking, allTokens());
 	}
 	
 	public SecUserBlocking loadSecUserBlocking(RetailscmUserContext userContext, String secUserBlockingId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfSecUserBlocking(secUserBlockingId);
		checkerOf(userContext).throwExceptionIfHasErrors( SecUserBlockingManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		SecUserBlocking secUserBlocking = loadSecUserBlocking( userContext, secUserBlockingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,secUserBlocking, tokens);
 	}
 	
 	
 	 public SecUserBlocking searchSecUserBlocking(RetailscmUserContext userContext, String secUserBlockingId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfSecUserBlocking(secUserBlockingId);
		checkerOf(userContext).throwExceptionIfHasErrors( SecUserBlockingManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		SecUserBlocking secUserBlocking = loadSecUserBlocking( userContext, secUserBlockingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,secUserBlocking, tokens);
 	}
 	
 	

 	protected SecUserBlocking present(RetailscmUserContext userContext, SecUserBlocking secUserBlocking, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,secUserBlocking,tokens);
		
		
		SecUserBlocking  secUserBlockingToPresent = secUserBlockingDaoOf(userContext).present(secUserBlocking, tokens);
		
		List<BaseEntity> entityListToNaming = secUserBlockingToPresent.collectRefercencesFromLists();
		secUserBlockingDaoOf(userContext).alias(entityListToNaming);
		
		return  secUserBlockingToPresent;
		
		
	}
 
 	
 	
 	public SecUserBlocking loadSecUserBlockingDetail(RetailscmUserContext userContext, String secUserBlockingId) throws Exception{	
 		SecUserBlocking secUserBlocking = loadSecUserBlocking( userContext, secUserBlockingId, allTokens());
 		return present(userContext,secUserBlocking, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String secUserBlockingId) throws Exception{	
 		SecUserBlocking secUserBlocking = loadSecUserBlocking( userContext, secUserBlockingId, viewTokens());
 		return present(userContext,secUserBlocking, allTokens());
		
 	}
 	protected SecUserBlocking saveSecUserBlocking(RetailscmUserContext userContext, SecUserBlocking secUserBlocking, Map<String,Object>tokens) throws Exception{	
 		return secUserBlockingDaoOf(userContext).save(secUserBlocking, tokens);
 	}
 	protected SecUserBlocking loadSecUserBlocking(RetailscmUserContext userContext, String secUserBlockingId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfSecUserBlocking(secUserBlockingId);
		checkerOf(userContext).throwExceptionIfHasErrors( SecUserBlockingManagerException.class);

 
 		return secUserBlockingDaoOf(userContext).load(secUserBlockingId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, SecUserBlocking secUserBlocking, Map<String, Object> tokens){
		super.addActions(userContext, secUserBlocking, tokens);
		
		addAction(userContext, secUserBlocking, tokens,"@create","createSecUserBlocking","createSecUserBlocking/","main","primary");
		addAction(userContext, secUserBlocking, tokens,"@update","updateSecUserBlocking","updateSecUserBlocking/"+secUserBlocking.getId()+"/","main","primary");
		addAction(userContext, secUserBlocking, tokens,"@copy","cloneSecUserBlocking","cloneSecUserBlocking/"+secUserBlocking.getId()+"/","main","primary");
		
		addAction(userContext, secUserBlocking, tokens,"sec_user_blocking.addSecUser","addSecUser","addSecUser/"+secUserBlocking.getId()+"/","secUserList","primary");
		addAction(userContext, secUserBlocking, tokens,"sec_user_blocking.removeSecUser","removeSecUser","removeSecUser/"+secUserBlocking.getId()+"/","secUserList","primary");
		addAction(userContext, secUserBlocking, tokens,"sec_user_blocking.updateSecUser","updateSecUser","updateSecUser/"+secUserBlocking.getId()+"/","secUserList","primary");
		addAction(userContext, secUserBlocking, tokens,"sec_user_blocking.copySecUserFrom","copySecUserFrom","copySecUserFrom/"+secUserBlocking.getId()+"/","secUserList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, SecUserBlocking secUserBlocking, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public SecUserBlocking createSecUserBlocking(RetailscmUserContext userContext, String who,String comments) throws Exception
	//public SecUserBlocking createSecUserBlocking(RetailscmUserContext userContext,String who, String comments) throws Exception
	{
		
		

		

		checkerOf(userContext).checkWhoOfSecUserBlocking(who);
		checkerOf(userContext).checkCommentsOfSecUserBlocking(comments);
	
		checkerOf(userContext).throwExceptionIfHasErrors(SecUserBlockingManagerException.class);


		SecUserBlocking secUserBlocking=createNewSecUserBlocking();	

		secUserBlocking.setWho(who);
		secUserBlocking.setBlockTime(userContext.now());
		secUserBlocking.setComments(comments);

		secUserBlocking = saveSecUserBlocking(userContext, secUserBlocking, emptyOptions());
		
		onNewInstanceCreated(userContext, secUserBlocking);
		return secUserBlocking;

		
	}
	protected SecUserBlocking createNewSecUserBlocking() 
	{
		
		return new SecUserBlocking();		
	}
	
	protected void checkParamsForUpdatingSecUserBlocking(RetailscmUserContext userContext,String secUserBlockingId, int secUserBlockingVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfSecUserBlocking(secUserBlockingId);
		checkerOf(userContext).checkVersionOfSecUserBlocking( secUserBlockingVersion);
		

		if(SecUserBlocking.WHO_PROPERTY.equals(property)){
			checkerOf(userContext).checkWhoOfSecUserBlocking(parseString(newValueExpr));
		}
		if(SecUserBlocking.COMMENTS_PROPERTY.equals(property)){
			checkerOf(userContext).checkCommentsOfSecUserBlocking(parseString(newValueExpr));
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(SecUserBlockingManagerException.class);
	
		
	}
	
	
	
	public SecUserBlocking clone(RetailscmUserContext userContext, String fromSecUserBlockingId) throws Exception{
		
		return secUserBlockingDaoOf(userContext).clone(fromSecUserBlockingId, this.allTokens());
	}
	
	public SecUserBlocking internalSaveSecUserBlocking(RetailscmUserContext userContext, SecUserBlocking secUserBlocking) throws Exception 
	{
		return internalSaveSecUserBlocking(userContext, secUserBlocking, allTokens());

	}
	public SecUserBlocking internalSaveSecUserBlocking(RetailscmUserContext userContext, SecUserBlocking secUserBlocking, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingSecUserBlocking(userContext, secUserBlockingId, secUserBlockingVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(secUserBlocking){ 
			//will be good when the secUserBlocking loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SecUserBlocking.
			if (secUserBlocking.isChanged()){
			
			}
			secUserBlocking = saveSecUserBlocking(userContext, secUserBlocking, options);
			return secUserBlocking;
			
		}

	}
	
	public SecUserBlocking updateSecUserBlocking(RetailscmUserContext userContext,String secUserBlockingId, int secUserBlockingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingSecUserBlocking(userContext, secUserBlockingId, secUserBlockingVersion, property, newValueExpr, tokensExpr);
		
		
		
		SecUserBlocking secUserBlocking = loadSecUserBlocking(userContext, secUserBlockingId, allTokens());
		if(secUserBlocking.getVersion() != secUserBlockingVersion){
			String message = "The target version("+secUserBlocking.getVersion()+") is not equals to version("+secUserBlockingVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(secUserBlocking){ 
			//will be good when the secUserBlocking loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SecUserBlocking.
			
			secUserBlocking.changeProperty(property, newValueExpr);
			secUserBlocking = saveSecUserBlocking(userContext, secUserBlocking, tokens().done());
			return present(userContext,secUserBlocking, mergedAllTokens(tokensExpr));
			//return saveSecUserBlocking(userContext, secUserBlocking, tokens().done());
		}

	}
	
	public SecUserBlocking updateSecUserBlockingProperty(RetailscmUserContext userContext,String secUserBlockingId, int secUserBlockingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingSecUserBlocking(userContext, secUserBlockingId, secUserBlockingVersion, property, newValueExpr, tokensExpr);
		
		SecUserBlocking secUserBlocking = loadSecUserBlocking(userContext, secUserBlockingId, allTokens());
		if(secUserBlocking.getVersion() != secUserBlockingVersion){
			String message = "The target version("+secUserBlocking.getVersion()+") is not equals to version("+secUserBlockingVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(secUserBlocking){ 
			//will be good when the secUserBlocking loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SecUserBlocking.
			
			secUserBlocking.changeProperty(property, newValueExpr);
			
			secUserBlocking = saveSecUserBlocking(userContext, secUserBlocking, tokens().done());
			return present(userContext,secUserBlocking, mergedAllTokens(tokensExpr));
			//return saveSecUserBlocking(userContext, secUserBlocking, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected SecUserBlockingTokens tokens(){
		return SecUserBlockingTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return SecUserBlockingTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortSecUserListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return SecUserBlockingTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String secUserBlockingId, int secUserBlockingVersion) throws Exception {
		//deleteInternal(userContext, secUserBlockingId, secUserBlockingVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String secUserBlockingId, int secUserBlockingVersion) throws Exception{
			
		secUserBlockingDaoOf(userContext).delete(secUserBlockingId, secUserBlockingVersion);
	}
	
	public SecUserBlocking forgetByAll(RetailscmUserContext userContext, String secUserBlockingId, int secUserBlockingVersion) throws Exception {
		return forgetByAllInternal(userContext, secUserBlockingId, secUserBlockingVersion);		
	}
	protected SecUserBlocking forgetByAllInternal(RetailscmUserContext userContext,
			String secUserBlockingId, int secUserBlockingVersion) throws Exception{
			
		return secUserBlockingDaoOf(userContext).disconnectFromAll(secUserBlockingId, secUserBlockingVersion);
	}
	
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new SecUserBlockingManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return secUserBlockingDaoOf(userContext).deleteAll();
	}


	//disconnect SecUserBlocking with domain in SecUser
	protected SecUserBlocking breakWithSecUserByDomain(RetailscmUserContext userContext, String secUserBlockingId, String domainId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SecUserBlocking secUserBlocking = loadSecUserBlocking(userContext, secUserBlockingId, allTokens());

			synchronized(secUserBlocking){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				secUserBlockingDaoOf(userContext).planToRemoveSecUserListWithDomain(secUserBlocking, domainId, this.emptyOptions());

				secUserBlocking = saveSecUserBlocking(userContext, secUserBlocking, tokens().withSecUserList().done());
				return secUserBlocking;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingSecUser(RetailscmUserContext userContext, String secUserBlockingId, String login, String mobile, String email, String pwd, String weixinOpenid, String weixinAppid, String accessToken, int verificationCode, DateTime verificationCodeExpire, DateTime lastLoginTime, String domainId,String [] tokensExpr) throws Exception{
<<<<<<< HEAD
		
=======
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
		
				checkerOf(userContext).checkIdOfSecUserBlocking(secUserBlockingId);

		
		checkerOf(userContext).checkLoginOfSecUser(login);
		
		checkerOf(userContext).checkMobileOfSecUser(mobile);
		
		checkerOf(userContext).checkEmailOfSecUser(email);
		
		checkerOf(userContext).checkPwdOfSecUser(pwd);
		
		checkerOf(userContext).checkWeixinOpenidOfSecUser(weixinOpenid);
		
		checkerOf(userContext).checkWeixinAppidOfSecUser(weixinAppid);
		
<<<<<<< HEAD
		userContext.getChecker().checkWeixinOpenidOfSecUser(weixinOpenid);
		
		userContext.getChecker().checkWeixinAppidOfSecUser(weixinAppid);
		
		userContext.getChecker().checkAccessTokenOfSecUser(accessToken);
		
		userContext.getChecker().checkVerificationCodeOfSecUser(verificationCode);
=======
		checkerOf(userContext).checkAccessTokenOfSecUser(accessToken);
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
		
		checkerOf(userContext).checkVerificationCodeOfSecUser(verificationCode);
		
		checkerOf(userContext).checkVerificationCodeExpireOfSecUser(verificationCodeExpire);
		
		checkerOf(userContext).checkLastLoginTimeOfSecUser(lastLoginTime);
		
		checkerOf(userContext).checkDomainIdOfSecUser(domainId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(SecUserBlockingManagerException.class);

	
	}
	public  SecUserBlocking addSecUser(RetailscmUserContext userContext, String secUserBlockingId, String login, String mobile, String email, String pwd, String weixinOpenid, String weixinAppid, String accessToken, int verificationCode, DateTime verificationCodeExpire, DateTime lastLoginTime, String domainId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingSecUser(userContext,secUserBlockingId,login, mobile, email, pwd, weixinOpenid, weixinAppid, accessToken, verificationCode, verificationCodeExpire, lastLoginTime, domainId,tokensExpr);
		
		SecUser secUser = createSecUser(userContext,login, mobile, email, pwd, weixinOpenid, weixinAppid, accessToken, verificationCode, verificationCodeExpire, lastLoginTime, domainId);
		
		SecUserBlocking secUserBlocking = loadSecUserBlocking(userContext, secUserBlockingId, allTokens());
		synchronized(secUserBlocking){ 
			//Will be good when the secUserBlocking loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			secUserBlocking.addSecUser( secUser );		
			secUserBlocking = saveSecUserBlocking(userContext, secUserBlocking, tokens().withSecUserList().done());
			
			userContext.getManagerGroup().getSecUserManager().onNewInstanceCreated(userContext, secUser);
			return present(userContext,secUserBlocking, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingSecUserProperties(RetailscmUserContext userContext, String secUserBlockingId,String id,String login,String mobile,String email,String pwd,String weixinOpenid,String weixinAppid,String accessToken,int verificationCode,DateTime verificationCodeExpire,DateTime lastLoginTime,String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfSecUserBlocking(secUserBlockingId);
		checkerOf(userContext).checkIdOfSecUser(id);
		
<<<<<<< HEAD
		userContext.getChecker().checkLoginOfSecUser( login);
		userContext.getChecker().checkMobileOfSecUser( mobile);
		userContext.getChecker().checkEmailOfSecUser( email);
		userContext.getChecker().checkPwdOfSecUser( pwd);
		userContext.getChecker().checkWeixinOpenidOfSecUser( weixinOpenid);
		userContext.getChecker().checkWeixinAppidOfSecUser( weixinAppid);
		userContext.getChecker().checkAccessTokenOfSecUser( accessToken);
		userContext.getChecker().checkVerificationCodeOfSecUser( verificationCode);
		userContext.getChecker().checkVerificationCodeExpireOfSecUser( verificationCodeExpire);
		userContext.getChecker().checkLastLoginTimeOfSecUser( lastLoginTime);
=======
		checkerOf(userContext).checkLoginOfSecUser( login);
		checkerOf(userContext).checkMobileOfSecUser( mobile);
		checkerOf(userContext).checkEmailOfSecUser( email);
		checkerOf(userContext).checkPwdOfSecUser( pwd);
		checkerOf(userContext).checkWeixinOpenidOfSecUser( weixinOpenid);
		checkerOf(userContext).checkWeixinAppidOfSecUser( weixinAppid);
		checkerOf(userContext).checkAccessTokenOfSecUser( accessToken);
		checkerOf(userContext).checkVerificationCodeOfSecUser( verificationCode);
		checkerOf(userContext).checkVerificationCodeExpireOfSecUser( verificationCodeExpire);
		checkerOf(userContext).checkLastLoginTimeOfSecUser( lastLoginTime);
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

		checkerOf(userContext).throwExceptionIfHasErrors(SecUserBlockingManagerException.class);
		
	}
	public  SecUserBlocking updateSecUserProperties(RetailscmUserContext userContext, String secUserBlockingId, String id,String login,String mobile,String email,String pwd,String weixinOpenid,String weixinAppid,String accessToken,int verificationCode,DateTime verificationCodeExpire,DateTime lastLoginTime, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingSecUserProperties(userContext,secUserBlockingId,id,login,mobile,email,pwd,weixinOpenid,weixinAppid,accessToken,verificationCode,verificationCodeExpire,lastLoginTime,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withSecUserListList()
				.searchSecUserListWith(SecUser.ID_PROPERTY, "is", id).done();
		
		SecUserBlocking secUserBlockingToUpdate = loadSecUserBlocking(userContext, secUserBlockingId, options);
		
		if(secUserBlockingToUpdate.getSecUserList().isEmpty()){
			throw new SecUserBlockingManagerException("SecUser is NOT FOUND with id: '"+id+"'");
		}
		
		SecUser item = secUserBlockingToUpdate.getSecUserList().first();
		
		item.updateLogin( login );
		item.updateMobile( mobile );
		item.updateEmail( email );
		item.updatePwd( pwd );
		item.updateWeixinOpenid( weixinOpenid );
		item.updateWeixinAppid( weixinAppid );
		item.updateAccessToken( accessToken );
		item.updateVerificationCode( verificationCode );
		item.updateVerificationCodeExpire( verificationCodeExpire );
		item.updateLastLoginTime( lastLoginTime );

		
		//checkParamsForAddingSecUser(userContext,secUserBlockingId,name, code, used,tokensExpr);
		SecUserBlocking secUserBlocking = saveSecUserBlocking(userContext, secUserBlockingToUpdate, tokens().withSecUserList().done());
		synchronized(secUserBlocking){ 
			return present(userContext,secUserBlocking, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected SecUser createSecUser(RetailscmUserContext userContext, String login, String mobile, String email, String pwd, String weixinOpenid, String weixinAppid, String accessToken, int verificationCode, DateTime verificationCodeExpire, DateTime lastLoginTime, String domainId) throws Exception{

		SecUser secUser = new SecUser();
		
		
		secUser.setLogin(login);		
		secUser.setMobile(mobile);		
		secUser.setEmail(email);		
		secUser.setClearTextOfPwd(pwd);		
		secUser.setWeixinOpenid(weixinOpenid);		
		secUser.setWeixinAppid(weixinAppid);		
		secUser.setAccessToken(accessToken);		
		secUser.setVerificationCode(verificationCode);		
		secUser.setVerificationCodeExpire(verificationCodeExpire);		
		secUser.setLastLoginTime(lastLoginTime);		
		UserDomain  domain = new UserDomain();
		domain.setId(domainId);		
		secUser.setDomain(domain);
	
		
		return secUser;
	
		
	}
	
	protected SecUser createIndexedSecUser(String id, int version){

		SecUser secUser = new SecUser();
		secUser.setId(id);
		secUser.setVersion(version);
		return secUser;			
		
	}
	
	protected void checkParamsForRemovingSecUserList(RetailscmUserContext userContext, String secUserBlockingId, 
			String secUserIds[],String [] tokensExpr) throws Exception {
		
<<<<<<< HEAD
		userContext.getChecker().checkIdOfSecUserBlocking(secUserBlockingId);
		for(String secUserIdItem: secUserIds){
			userContext.getChecker().checkIdOfSecUser(secUserIdItem);
=======
		checkerOf(userContext).checkIdOfSecUserBlocking(secUserBlockingId);
		for(String secUserIdItem: secUserIds){
			checkerOf(userContext).checkIdOfSecUser(secUserIdItem);
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
		}
		
		checkerOf(userContext).throwExceptionIfHasErrors(SecUserBlockingManagerException.class);
		
	}
	public  SecUserBlocking removeSecUserList(RetailscmUserContext userContext, String secUserBlockingId, 
			String secUserIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingSecUserList(userContext, secUserBlockingId,  secUserIds, tokensExpr);
			
			
			SecUserBlocking secUserBlocking = loadSecUserBlocking(userContext, secUserBlockingId, allTokens());
			synchronized(secUserBlocking){ 
				//Will be good when the secUserBlocking loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				secUserBlockingDaoOf(userContext).planToRemoveSecUserList(secUserBlocking, secUserIds, allTokens());
				secUserBlocking = saveSecUserBlocking(userContext, secUserBlocking, tokens().withSecUserList().done());
				deleteRelationListInGraph(userContext, secUserBlocking.getSecUserList());
				return present(userContext,secUserBlocking, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingSecUser(RetailscmUserContext userContext, String secUserBlockingId, 
		String secUserId, int secUserVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfSecUserBlocking( secUserBlockingId);
		checkerOf(userContext).checkIdOfSecUser(secUserId);
		checkerOf(userContext).checkVersionOfSecUser(secUserVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(SecUserBlockingManagerException.class);
	
	}
	public  SecUserBlocking removeSecUser(RetailscmUserContext userContext, String secUserBlockingId, 
		String secUserId, int secUserVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingSecUser(userContext,secUserBlockingId, secUserId, secUserVersion,tokensExpr);
		
		SecUser secUser = createIndexedSecUser(secUserId, secUserVersion);
		SecUserBlocking secUserBlocking = loadSecUserBlocking(userContext, secUserBlockingId, allTokens());
		synchronized(secUserBlocking){ 
			//Will be good when the secUserBlocking loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			secUserBlocking.removeSecUser( secUser );		
			secUserBlocking = saveSecUserBlocking(userContext, secUserBlocking, tokens().withSecUserList().done());
			deleteRelationInGraph(userContext, secUser);
			return present(userContext,secUserBlocking, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingSecUser(RetailscmUserContext userContext, String secUserBlockingId, 
		String secUserId, int secUserVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfSecUserBlocking( secUserBlockingId);
		checkerOf(userContext).checkIdOfSecUser(secUserId);
		checkerOf(userContext).checkVersionOfSecUser(secUserVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(SecUserBlockingManagerException.class);
	
	}
	public  SecUserBlocking copySecUserFrom(RetailscmUserContext userContext, String secUserBlockingId, 
		String secUserId, int secUserVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingSecUser(userContext,secUserBlockingId, secUserId, secUserVersion,tokensExpr);
		
		SecUser secUser = createIndexedSecUser(secUserId, secUserVersion);
		SecUserBlocking secUserBlocking = loadSecUserBlocking(userContext, secUserBlockingId, allTokens());
		synchronized(secUserBlocking){ 
			//Will be good when the secUserBlocking loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			secUserBlocking.copySecUserFrom( secUser );		
			secUserBlocking = saveSecUserBlocking(userContext, secUserBlocking, tokens().withSecUserList().done());
			
			userContext.getManagerGroup().getSecUserManager().onNewInstanceCreated(userContext, (SecUser)secUserBlocking.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,secUserBlocking, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingSecUser(RetailscmUserContext userContext, String secUserBlockingId, String secUserId, int secUserVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfSecUserBlocking(secUserBlockingId);
		checkerOf(userContext).checkIdOfSecUser(secUserId);
		checkerOf(userContext).checkVersionOfSecUser(secUserVersion);
		

		if(SecUser.LOGIN_PROPERTY.equals(property)){
			checkerOf(userContext).checkLoginOfSecUser(parseString(newValueExpr));
		}
		
		if(SecUser.MOBILE_PROPERTY.equals(property)){
			checkerOf(userContext).checkMobileOfSecUser(parseString(newValueExpr));
		}
		
		if(SecUser.EMAIL_PROPERTY.equals(property)){
			checkerOf(userContext).checkEmailOfSecUser(parseString(newValueExpr));
		}
		
		if(SecUser.PWD_PROPERTY.equals(property)){
			checkerOf(userContext).checkPwdOfSecUser(parseString(newValueExpr));
		}
		
		if(SecUser.WEIXIN_OPENID_PROPERTY.equals(property)){
			checkerOf(userContext).checkWeixinOpenidOfSecUser(parseString(newValueExpr));
		}
		
		if(SecUser.WEIXIN_APPID_PROPERTY.equals(property)){
			checkerOf(userContext).checkWeixinAppidOfSecUser(parseString(newValueExpr));
		}
		
		if(SecUser.ACCESS_TOKEN_PROPERTY.equals(property)){
			checkerOf(userContext).checkAccessTokenOfSecUser(parseString(newValueExpr));
		}
		
		if(SecUser.WEIXIN_OPENID_PROPERTY.equals(property)){
			userContext.getChecker().checkWeixinOpenidOfSecUser(parseString(newValueExpr));
		}
		
		if(SecUser.WEIXIN_APPID_PROPERTY.equals(property)){
			userContext.getChecker().checkWeixinAppidOfSecUser(parseString(newValueExpr));
		}
		
		if(SecUser.ACCESS_TOKEN_PROPERTY.equals(property)){
			userContext.getChecker().checkAccessTokenOfSecUser(parseString(newValueExpr));
		}
		
		if(SecUser.VERIFICATION_CODE_PROPERTY.equals(property)){
			checkerOf(userContext).checkVerificationCodeOfSecUser(parseInt(newValueExpr));
		}
		
		if(SecUser.VERIFICATION_CODE_EXPIRE_PROPERTY.equals(property)){
			checkerOf(userContext).checkVerificationCodeExpireOfSecUser(parseTimestamp(newValueExpr));
		}
		
		if(SecUser.LAST_LOGIN_TIME_PROPERTY.equals(property)){
			checkerOf(userContext).checkLastLoginTimeOfSecUser(parseTimestamp(newValueExpr));
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(SecUserBlockingManagerException.class);
	
	}
	
	public  SecUserBlocking updateSecUser(RetailscmUserContext userContext, String secUserBlockingId, String secUserId, int secUserVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingSecUser(userContext, secUserBlockingId, secUserId, secUserVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withSecUserList().searchSecUserListWith(SecUser.ID_PROPERTY, "eq", secUserId).done();
		
		
		
		SecUserBlocking secUserBlocking = loadSecUserBlocking(userContext, secUserBlockingId, loadTokens);
		
		synchronized(secUserBlocking){ 
			//Will be good when the secUserBlocking loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//secUserBlocking.removeSecUser( secUser );	
			//make changes to AcceleraterAccount.
			SecUser secUserIndex = createIndexedSecUser(secUserId, secUserVersion);
		
			SecUser secUser = secUserBlocking.findTheSecUser(secUserIndex);
			if(secUser == null){
				throw new SecUserBlockingManagerException(secUser+" is NOT FOUND" );
			}
			
			secUser.changeProperty(property, newValueExpr);
			
			secUserBlocking = saveSecUserBlocking(userContext, secUserBlocking, tokens().withSecUserList().done());
			return present(userContext,secUserBlocking, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(RetailscmUserContext userContext, SecUserBlocking newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


