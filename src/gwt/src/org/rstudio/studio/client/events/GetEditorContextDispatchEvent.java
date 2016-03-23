/*
 * GetEditorContextDispatchEvent.java
 *
 * Copyright (C) 2009-13 by RStudio, Inc.
 *
 * Unless you have received this program directly from RStudio pursuant
 * to the terms of a commercial license agreement with RStudio, then
 * this program is licensed to you under the terms of version 3 of the
 * GNU Affero General Public License. This program is distributed WITHOUT
 * ANY EXPRESS OR IMPLIED WARRANTY, INCLUDING THOSE OF NON-INFRINGEMENT,
 * MERCHANTABILITY OR FITNESS FOR A PARTICULAR PURPOSE. Please refer to the
 * AGPL (http://www.gnu.org/licenses/agpl-3.0.txt) for more details.
 *
 */
package org.rstudio.studio.client.events;

import com.google.gwt.event.shared.EventHandler;

import org.rstudio.core.client.js.JavaScriptSerializable;
import org.rstudio.studio.client.application.events.CrossWindowEvent;

@JavaScriptSerializable
public class GetEditorContextDispatchEvent extends CrossWindowEvent<GetEditorContextDispatchEvent.Handler>
{
   public interface Handler extends EventHandler
   {
      void onGetEditorContextDispatch(GetEditorContextDispatchEvent event);
   }
   
   public GetEditorContextDispatchEvent()
   {
      this(null);
   }
   
   public GetEditorContextDispatchEvent(GetEditorContextEvent event)
   {
      event_ = event;
   }
   
   public GetEditorContextEvent getEvent()
   {
      return event_;
   }
   
   @Override
   public boolean forward()
   {
      return false;
   }
   
   private final GetEditorContextEvent event_;
   
   // Boilerplate ----
   
   @Override
   public Type<Handler> getAssociatedType()
   {
      return TYPE;
   }

   @Override
   protected void dispatch(Handler handler)
   {
      handler.onGetEditorContextDispatch(this);
   }
   
   public static final Type<Handler> TYPE = new Type<Handler>();

}