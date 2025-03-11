import JsonSchemaBuilder from '@/components/JsonSchemaBuilder/JsonSchemaBuilder';
import {SchemaRecordType} from '@/components/JsonSchemaBuilder/utils/types';
import {Sheet, SheetCloseButton, SheetContent, SheetDescription, SheetHeader, SheetTitle} from '@/components/ui/sheet';
import {Tabs, TabsContent, TabsList, TabsTrigger} from '@/components/ui/tabs';
import {SPACE} from '@/shared/constants';
import Editor from '@monaco-editor/react';
import React from 'react';

interface PropertyJsonSchemaBuilderSheetProps {
    locale?: string;
    onChange?: (newSchema: SchemaRecordType) => void;
    onClose?: () => void;
    schema?: SchemaRecordType;
}

const PropertyJsonSchemaBuilderSheet = ({locale, onChange, onClose, schema}: PropertyJsonSchemaBuilderSheetProps) => {
    return (
        <Sheet onOpenChange={onClose} open>
            <SheetContent
                className="flex w-11/12 flex-col gap-0 p-0 sm:max-w-screen-lg"
                onFocusOutside={(event) => event.preventDefault()}
                onPointerDownOutside={(event) => event.preventDefault()}
            >
                <Tabs className="flex size-full flex-col" defaultValue="designer">
                    <SheetHeader className="flex flex-row items-center justify-between space-y-0 p-3">
                        <div className="flex flex-col">
                            <SheetTitle>JSON Schema Builder</SheetTitle>

                            <SheetDescription>Define desired response format for the output</SheetDescription>
                        </div>

                        <div className="flex items-center gap-1">
                            {/*TODO Fix refresh doesn't not work properly, backend does not always return correct schema*/}

                            {/*<PropertyJsonSchemaBuilderSampleDataDialog onChange={onChange} />*/}

                            <TabsList>
                                <TabsTrigger value="designer">Designer</TabsTrigger>

                                <TabsTrigger value="editor">Editor</TabsTrigger>
                            </TabsList>

                            <SheetCloseButton />
                        </div>
                    </SheetHeader>

                    <div className="flex-1 overflow-y-auto px-4">
                        <TabsContent value="designer">
                            <JsonSchemaBuilder locale={locale} onChange={onChange} schema={schema} />
                        </TabsContent>

                        <TabsContent className="h-full" value="editor">
                            <Editor
                                defaultLanguage="json"
                                onChange={(value) => {
                                    if (value && onChange) {
                                        onChange(JSON.parse(value));
                                    }
                                }}
                                value={JSON.stringify(schema, null, SPACE)}
                            />
                        </TabsContent>
                    </div>
                </Tabs>
            </SheetContent>
        </Sheet>
    );
};

export default PropertyJsonSchemaBuilderSheet;
