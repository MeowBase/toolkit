/*
 * Copyright (c) 2021. The Meowool Organization Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * In addition, if you modified the project, you must include the Meowool
 * organization URL in your code file: https://github.com/meowool
 *
 * 如果您修改了此项目，则必须确保源文件中包含 Meowool 组织 URL: https://github.com/meowool
 */
package com.meowool.sweekt.info

import com.meowool.sweekt.SweektNames.Info
import org.jetbrains.kotlin.descriptors.DeclarationDescriptor
import org.jetbrains.kotlin.descriptors.FunctionDescriptor
import org.jetbrains.kotlin.psi.KtDeclaration
import org.jetbrains.kotlin.psi.KtFunction
import org.jetbrains.kotlin.resolve.DescriptorUtils
import org.jetbrains.kotlin.resolve.checkers.DeclarationChecker
import org.jetbrains.kotlin.resolve.checkers.DeclarationCheckerContext

/**
 * @author 凛 (RinOrz)
 */
object InfoFunctionChecker : DeclarationChecker {
  override fun check(
    declaration: KtDeclaration,
    descriptor: DeclarationDescriptor,
    context: DeclarationCheckerContext
  ) {
    if (descriptor !is FunctionDescriptor) return
    if (declaration !is KtFunction) return
    if (!descriptor.containingDeclaration.annotations.hasAnnotation(Info)) return

    val name = declaration.name ?: return
    if (InfoClassDescriptorResolver.isComponentLike(name)) {
      if (descriptor.isOperator.not()) context.trace.report(
        InfoErrors.ComponentRequiredOperator.on(declaration.nameIdentifier ?: declaration)
      )
    }

    when (name) {
      "infoEquals", "infoHashCode", "infoToString" -> if (DescriptorUtils.isOverride(descriptor)) {
        context.trace.report(
          InfoErrors.NotAllowedOverrideSynthetic.on(declaration.nameIdentifier ?: declaration, name)
        )
      }
    }
  }
}
